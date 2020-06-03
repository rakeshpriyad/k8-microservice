insert the entry in mongodb

{"username": "username",
"password": "password"
}

from the rest client hit the following as post request:

http://localhost:8080/api/signin

with values:
{
  "username": "username",
  "password":"password"
  
}