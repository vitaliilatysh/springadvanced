How check the demo program on your localhost machine

1. Clone the repository
2. Go to the project root folder
3. Run mvn spring-boot:run
4. Check localhost:9090
5. Follow specific module steps

Module#1 - Spring MVC
1. Get file examples from /resources/files and upload batch in next order - users.json, companies.json, phones.json
2. Click on 'Show users' - PDF file with uploaded users returned
3. Click on 'Show phones' - json of uploaded phones returned
4. Click on 'Show companies' - json of uploaded companies returned

Module#2 - Spring Security
1. Login with admin/admin. The user is created during app startup
2. Get file examples from /resources/files and upload batch in next order - users.json, companies.json, phones.json
3. Log out and login with dmacconel/1234 - redirected to /users/2 with user info
4. Try to get /users/3 - get error page
