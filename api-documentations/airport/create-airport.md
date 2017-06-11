**Create Airport**
----
  Create an airport

* **URL**

  /rs/airport/create

* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**

  **Required:** `airportcode=[string]`
  
  **Required:** `city=[string]`
  
  **Required:** `country=[string]`
  
  **Required:** `name=[string]`

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

  * **Code:** 500 Server Error
  
    **Content:** `{ error : "Cannot create airport" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airport/create",
      dataType: "json",
      type : "POST",
      data: {"name": "SkyTeam", "country": "Nepal", "city": "Kathmandu", "airportcode": "TIA"},
      success : function(r) {
        console.log(r);
      }
    });
  ```