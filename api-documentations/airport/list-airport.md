**List Airport**
----
  Returns json data for list of airport.

* **URL**

  /rs/airport

* **Method:**

  `GET`
  
*  **URL Params**

   None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200
  
    **Content:** 
    ```
    [
        {
            "airportcode": "AMS",
            "city": "Amsterdam",
            "country": "The Netherlands",
            "id": 4,
            "name": "Schiphol"
        },
        {
            "airportcode": "DTW",
            "city": "Detroid",
            "country": "USA",
            "id": 5,
            "name": "Detroid City"
        }
    ]
    ```
 
* **Error Response:**

  None

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airport",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```