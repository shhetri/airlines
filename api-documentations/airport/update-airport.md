**Update Airport**
----
  Update an airport

* **URL**

  /rs/airport/:id

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:** `id=[integer]`

* **Data Params**

  **Required:** `airportcode=[string]`
    
  **Required:** `city=[string]`
    
  **Required:** `country=[string]`
    
  **Required:** `name=[string]`

* **Success Response:**

  * **Code:** 200
  * **Content:** 
    ```
    {
        "airportcode": "JFK",
        "city": "New York",
        "country": "USA",
        "name": "John F. Kennedy International"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Update failed." }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Airport with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airport/1",
      dataType: "json",
      type : "PUT",
      data: {"name": "John F. Kennedy International", "country": "USA", "city": "New york City", "airportcode": "JFK"},
      success : function(r) {
        console.log(r);
      }
    });
  ```