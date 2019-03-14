openssl genrsa 2048 > myapp-wildcard.key
openssl req -new -x509 -nodes -sha1 -days 3650 -key myapp-wildcard.key > myapp-wildcard.cert
openssl x509 -noout -fingerprint -text < app_name-wildcard.cert > app_name-wildcard.info
cat myapp-wildcard.cert myapp-wildcard.key > myapp-wildcard.pem
chmod 644 app_name-wildcard.key app_name-wildcard.pem