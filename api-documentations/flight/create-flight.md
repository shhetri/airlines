**Create Flight**
----
  Create an flight

* **URL**

  /rs/flight/create

* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**

  **Required:** `flightnr=[string]`
  
  **Required:** `arrivalDate=[date]`
  
  **Required:** `arrivalTime=[time]`
  
  **Required:** `departureDate=[date]`
  
  **Required:** `departureTime=[time]`
  
* **Success Response:**

  * **Code:** 200
  
    **Content:** 
    ```
    {
        "arrivalDate": "6/25/15",
        "arrivalTime": "1:45 PM",
        "departureDate": "8/6/09",
        "departureTime": "3:05 PM",
        "flightnr": "NW 101",
        "id": 1852
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
  
    **Content:** `{ error : "Cannot create flight" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/flight/create",
      dataType: "json",
      type : "POST",
      data: {
            "arrivalDate": "6/25/15",
            "arrivalTime": "1:45 PM",
            "departureDate": "8/6/09",
            "departureTime": "3:05 PM",
            "flightnr": "NW 101"
        },
      success : function(r) {
        console.log(r);
      }
    });
  ```