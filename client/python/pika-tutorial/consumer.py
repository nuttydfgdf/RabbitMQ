import os
import sys
import datetime

import logging
from datetime import date
import pika, os, time

from dotenv import load_dotenv

load_dotenv()  # take environment variables from .env.

print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ")
print("Start Pika consumer")


# logging.basicConfig(filename = 'file.log',
#                     level = logging.DEBUG,
#                     format= '[%(asctime)s] [%(levelname)s] {%(name)s:%(lineno)d} - %(message)s')

# set up logging to console
console = logging.StreamHandler()
console.setLevel(logging.INFO)
# set a format which is simpler for console use
formatter = logging.Formatter('[%(asctime)s] [%(levelname)s] {%(name)s:%(lineno)d} - %(message)s')
console.setFormatter(formatter)
# add the handler to the root logger
logging.getLogger('').addHandler(console)

logger = logging.getLogger(__name__)


RABBITMQ_HOST = os.getenv('RABBITMQ_HOST')
RABBITMQ_PORT = os.getenv('RABBITMQ_PORT')
RABBITMQ_USER = os.getenv('RABBITMQ_USER')
RABBITMQ_PASS = os.getenv('RABBITMQ_PASS')


# Access the CLODUAMQP_URL environment variable and parse it (fallback to localhost)
credentials = pika.PlainCredentials(RABBITMQ_USER, RABBITMQ_PASS)
parameters = pika.ConnectionParameters(RABBITMQ_HOST,
                                       RABBITMQ_PORT,
                                       '/',
                                       credentials)
connection = pika.BlockingConnection(parameters)
channel = connection.channel() # start a channel

# channel.queue_declare(queue='pdfprocess') # Declare a queue
# Create Exchange 'logs'
channel.exchange_declare(exchange='logs', exchange_type='fanout')
# result = channel.queue_declare(queue='logs.queue', exclusive=True)
result = channel.queue_declare(queue='', exclusive=True) # Random queue name
queue_name = result.method.queue

# Set Queue logs.queue bind with logs exchange
channel.queue_bind(exchange='logs', queue=queue_name)

logger.info(" - - - start consuming - - - -")
print(' [*] Waiting for logs. To exit press CTRL+C')

# create a function which is called on incoming messages
def callback(ch, method, properties, body):
    print(" [x] Log Received %r" % body)
    logger.info(body)


# set up subscription on the queue
channel.basic_consume(queue_name, callback,auto_ack=True)

# start consuming (blocks)
channel.start_consuming()
connection.close()