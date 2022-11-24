#!/usr/bin/env python
import pika
import uuid
import random
import os
from dotenv import load_dotenv

load_dotenv()  # take environment variables from .env.

RABBITMQ_HOST = os.getenv('RABBITMQ_HOST')
RABBITMQ_PORT = os.getenv('RABBITMQ_PORT')
RABBITMQ_USER = os.getenv('RABBITMQ_USER')
RABBITMQ_PASS = os.getenv('RABBITMQ_PASS')


class FibonacciRpcClient(object):

    def __init__(self):
        # Access the CLODUAMQP_URL environment variable and parse it (fallback to localhost)
        credentials = pika.PlainCredentials(RABBITMQ_USER, RABBITMQ_PASS)
        parameters = pika.ConnectionParameters(RABBITMQ_HOST, RABBITMQ_PORT, '/', credentials)

        self.connection = pika.BlockingConnection(parameters)

        self.channel = self.connection.channel()

        self.channel.queue_declare(queue='rpc_queue')

        # Declare queue name which is consume app connect to this queue, when the server returns a response.
        result = self.channel.queue_declare(queue='rpc_answer', exclusive=True)
        self.callback_queue = result.method.queue

        self.channel.basic_consume(
            queue=self.callback_queue,
            on_message_callback=self.on_response,
            auto_ack=True)

        self.response = None
        self.corr_id = None

    def on_response(self, ch, method, props, body):
        if self.corr_id == props.correlation_id:
            self.response = body

    def call(self, n):
        self.response = None
        self.corr_id = str(uuid.uuid4()) # Generate UUID is unique value 

        self.channel.basic_publish(
            exchange='',             # Push message into default Exchange.
            routing_key='rpc_queue', # The routing key is a message attribute. A message goes to the queue(s) with the binding key that exactly matches the routing key of the message.
            properties=pika.BasicProperties(
                reply_to=self.callback_queue, # Reply_to is a Request-Reply messages, It means to reply as specified queue name. 
                correlation_id=self.corr_id,
            ),
            body=str(n))
        self.connection.process_data_events(time_limit=None)
        return int(self.response)

# Create RPC Client
fibonacci_rpc = FibonacciRpcClient()

for n in range(5):
    # Generates a random number between
    # a given positive range
    r1 = random.randint(1, 10)
    # print("Random number between 1 and 10 is % s" % (r1))

    print(" [x] Requesting fib(% s) " % (r1))
    response = fibonacci_rpc.call(r1)
    print(" [.] Got %r" % response)