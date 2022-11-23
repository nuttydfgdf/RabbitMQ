// Auto-generated by the postman-to-k6 converter

import "./libs/shim/core.js";

export let options = { maxRedirects: 4 };

const Request = Symbol.for("request");
postman[Symbol.for("initial")]({
  options
});

export default function() {
  postman[Request]({
    name: "Create Order",
    id: "1ccdc121-d11e-4e8c-b36f-bf07fb35db0f",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    address: "http://localhost:8080/orders",
    data:
      '{\r\n    "userId" : "{{$randomUserName}}",\r\n    "productName" : "{{$randomProductName}}",\r\n    "price" : {{$randomPrice}},\r\n    "qty": {{$randomInt}},\r\n    "customersId" : "{{$randomBitcoin}}",\r\n    "customerName" : "{{$randomFullName}}",\r\n    "customerAddress" : "{{$randomStreetAddress}}",\r\n    "customerEmail" : "{{$randomEmail}}",\r\n    "customerMobileNo" : "{{$randomPhoneNumber}}",\r\n    "paymentMethod" : "BANK_TRANSFER",\r\n    "bankAccountNo" : "{{$randomBankAccount}}",\r\n    "bankAccountName" : "{{$randomBankAccountName}}",\r\n    "currency" : "{{$randomCurrencyCode}}",\r\n    "shippingModule" : "FLASH"\r\n}\r\n'
  });
}
