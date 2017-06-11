**Find Airport By ID**
----
  Returns json data about an airport

* **URL**

  /rs/airport/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200
  
    **Content:** 
    ```
       {
           "airportcode": "AMS",
           "city": "Amsterdam",
           "country": "The Netherlands",
           "id": 4,
           "name": "Schiphol"
       }
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND
  
    **Content:** `{ error : "Airport with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airport/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```