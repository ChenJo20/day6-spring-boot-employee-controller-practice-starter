1. GET #obtain company list with response of id,name<br>
Method: get <br>
URI: /companies <br>
Response Status: 200 <br>
Response Body: 
`[
    {
        "id":1,
        "name": "company1"
    },
    {
        "id":2,
        "name": "company2"
    }
]`
2. GET #obtain a certain specific company with response of id,name<br>
   Method: get <br>
   URI: /companies/{id} <br>
   Response Status: 200 <br>
   Response Body:
   `
   {
   "id":1,
   "name": "company1"
   }
   `
3. GET #obtain list of all employee under a certain specific company
   Method: get <br>
   URI: /employees/{companyId} <br>
   Response Status: 200 <br>
   Response Body:
   `[
   {
   "id":1,
   "name": "Johnson",
    "age": 22,
    "gender": "M",
    "salary": 100.0,
    "companyId": 1
   }
   ]`
4. GET #Page query, page equals1, size equals 5, it will return the data in company list from index 0 to index 4<br>
      Method: get <br>
      URI: /companies?page=1&size=5<br>
      Response Status: 200 <br>
      Response Body:
      `[
      {
      "id":1,
      "name": "company1"
      },{
      "id":2,
      "name": "company2"
      },{
      "id":3,
      "name": "company3"
      },{
      "id":4,
      "name": "company4"
      },{
      "id":5,
      "name": "company5"
      },
      ]`
5. PUT #update an employee with company<br>
Method: put<br>
URI: /employees<br>
Request Body:
   `[
   {
   "id":1,
   "companyId": 1
}
   ]` <br>
Response Status: 200<br>
Response Body: 
`
   {
   "id":1,
    "name": "Johnson",
    "age": 22,
    "gender": "M",
    "salary": 600.0,
   "companyId": 1
   }
`
6. POST #add a company<br>
      Method: post<br>
      URI: /companies<br>
      Request Body:
      `
      {
      "id":1,
      "name": "company1"
      }
      ` <br>
      Response Status: 201<br>
      Response Body:
      `
      {
      "id":1,
      "name": "company1"
      }
      `
7. DELETE #delete a company<br>
      Method: delete<br>
      URI: /companies<br>
      Request Body:
      `
      {
      "id":1
      }
      ` <br>
      Response Status: 204<br>
