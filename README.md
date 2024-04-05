## Employee REST API

**This API provides endpoints for managing employee data.**

**## Getting Started**

**To use this API, you'll need a tool that can make HTTP requests, such as Postman or curl.**

**All API endpoints are prefixed with `/employee`.**

## API Endpoints

Here's a list of the available API endpoints:

**### Get all employees:**

```
GET /employee/all
```

**### Get employee by ID:**

```
GET /employee/{id}
```

**Replace `{id}` with the actual employee ID.**

**### Add a new employee:**

```
POST /employee/add
```

**Include employee details in the request body in JSON format.**

**### Update an existing employee:**

```
PUT /employee/update/{id}
```

**Replace `{id}` with the actual employee ID.**

**Include updated employee details in the request body in JSON format.**

**### Delete an employee:**

```
DELETE /employee/delete/{id}
```

**Replace `{id}` with the actual employee ID.**

**### Search for employees:**

```
GET /employee/search
```

**Use query parameters to filter search results.**

## Search Filters

The following search filters are supported:

* **name**: Filter by employee name (e.g., `/employee/search?name={name}`)
* **department.department1.id**: Filter by department 1 ID (e.g., `/employee/search?department.department1.id={departmentId}`)
* **department.department1.name**: Filter by department 1 name (e.g., `/employee/search?department.department1.name={departmentName}`)
* **department.department2.id**: Filter by department 2 ID (e.g., `/employee/search?department.department2.id={departmentId}`)
* **department.department2.name**: Filter by department 2 name (e.g., `/employee/search?department.department2.name={departmentName}`)
* **dob**: Filter by date of birth (format: YYYY-MM-DD) (e.g., `/employee/search?dob={dateOfBirth}`)
* **localAddress.street**: Filter by local address street (e.g., `/employee/search?localAddress.street={streetAddress}`)
* **localAddress.city**: Filter by local address city (e.g., `/employee/search?localAddress.city={city}`)
* **localAddress.zipCode**: Filter by local address zip code (e.g., `/employee/search?localAddress.zipCode={zipCode}`)
* **officeAddress.street**: Filter by office address street (e.g., `/employee/search?officeAddress.street={streetAddress}`)
* **officeAddress.city**: Filter by office address city (e.g., `/employee/search?officeAddress.city={city}`)
* **officeAddress.zipCode**: Filter by office address zip code (e.g., `/employee/search?officeAddress.zipCode={zipCode}`)
* **salary**: Filter by salary (e.g., `/employee/search?salary={salary}`)
* **spouse**: Filter by spouse name (e.g., `/employee/search?spouse={spouseName}`)
* **kid**: Filter by kid name (e.g., `/employee/search?kid={kidName}`)
* **parent**: Filter by parent name (e.g., `/employee/search?parent={parentName}`)
* **parentInLaw**: Filter by parent in law name (e.g., `/employee/search?parentInLaw={parentInLawName}`)
* **otherDependent**: Filter by other dependent name (e.g., `/employee/search?otherDependent={otherDependentName}`)

**Combine multiple filters using the `&` symbol.**

**For example, you can search for employees who are in department 1 with ID 10 and have a salary greater than 50000: `/employee/search?department.department1.id=10&salary=50000`**

**Replace `{name}`, `{departmentId}`, `{departmentName}`, `{dateOfBirth}`, `{streetAddress}`, `{city}`, `{zipCode}`, `{salary}`, `{spouseName}`, `{kidName}`, `{parentName}`, `{parentInLawName}`, and `{otherDependentName}` with your desired search criteria. 

## Sample Employee JSON object
```
[
    {
        "address": {
            "localAddress": {
                "city": "Springfield",
                "street": "123 Main St",
                "zipCode": "12345"
            },
            "officeAddress": {
                "city": "Springfield",
                "street": "456 Office Ave",
                "zipCode": "54321"
            }
        },
        "department": {
            "department1": {
                "id": 1,
                "name": "IT"
            },
            "department2": {
                "id": 2,
                "name": "HR"
            }
        },
        "dob": "1990-01-01",
        "family": {
            "dependents": {
                "others": [
                    "Other dependent 1",
                    "Other dependent 2"
                ],
                "parents": [
                    "Parent 1",
                    "Parent 2"
                ],
                "parentsInLaw": [
                    "Parent in law 1",
                    "Parent in law 2"
                ]
            },
            "kids": [
                "Alice",
                "Bob"
            ],
            "spouse": "Jane Doe"
        },
        "id": 1,
        "name": "John Doe",
        "salary": 60000.0
    }
]
```-