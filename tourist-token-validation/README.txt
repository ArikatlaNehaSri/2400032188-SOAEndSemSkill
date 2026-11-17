TOURIST TOKEN VALIDATION - STS PROJECT
======================================
Requirements: JDK 17, STS, Postman. Internet is needed on first Maven build.

IMPORT AND RUN:
1. Extract this ZIP.
2. STS -> File -> Import -> Maven -> Existing Maven Projects.
3. Browse to the extracted TouristTokenValidation folder; select pom.xml -> Finish.
4. Wait for Maven dependencies to download.
5. Open TouristTokenValidationApplication.java -> Run As -> Spring Boot App.
6. App runs at http://localhost:8080. A sample tourist is inserted with ID 1.

POSTMAN TESTS (run in this order):

1. GENERATE TOKEN
POST http://localhost:8080/api/auth/token
No body required.
Expected 200 OK:
{"message":"Token generated successfully","token":"<generated-token>"}
Copy the actual token returned.

2. UPDATE WITH VALID TOKEN
PUT http://localhost:8080/api/tourist/1
Headers:
Content-Type: application/json
Token: <paste the generated token>
Body -> raw -> JSON:
{
  "name": "Rahul",
  "visitedDestination": "Hyderabad",
  "contactDetails": "9999999999"
}
Expected 200 OK and the updated tourist JSON.

3. VERIFY
GET http://localhost:8080/api/tourist/1
Expected 200 OK with Hyderabad and 9999999999.

4. INVALID TOKEN TEST
PUT http://localhost:8080/api/tourist/1
Headers: Content-Type: application/json
Token: wrong-token
Use a JSON body (for example, destination Chennai).
Expected 403 Forbidden:
{"error":"Invalid or missing token"}

NOTES:
- Generate a fresh token after restarting the application; tokens are stored in memory.
- This is a simple lab demonstration, not production authentication. A real token endpoint must authenticate the user and use expiry/signature validation.
- Header name is exactly Token, as in the lab question.
