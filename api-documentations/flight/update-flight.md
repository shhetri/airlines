**Update Flight**
----
  Update an flight

* **URL**

  /rs/flight/:id

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:** `id=[integer]`

* **Data Params**

  **Required:** `flightnr=[string]`
    
  **Required:** `arrivalDate=[date]`
    
  **Required:** `arrivalTime=[time]`
    
  **Required:** `departureDate=[date]`
    
  **Required:** `departureTime=[time]`

* **Success Response:**

  * **Code:** 200
  * **Content:** 
    ```
    {
        "airline": {
            "id": 2,
            "name": "SkyTeam"
        },
        "airplane": {
            "capacity": 416,
            "id": 7,
            "model": "747",
            "serialnr": "54321"
        },
        "arrivalDate": "6/25/15",
        "arrivalTime": "1:45 PM",
        "departureDate": "8/6/09",
        "departureTime": "3:05 PM",
        "destination": {
            "airportcode": "DTW",
            "city": "Detroid",
            "country": "USA",
            "id": 5,
            "name": "Detroid City"
        },
        "flightnr": "NW 96",
        "id": 6,
        "origin": {
            "airportcode": "NRT",
            "city": "Tokyo",
            "country": "Japan",
            "id": 8,
            "name": "Narita International Airport"
        }
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Update failed." }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Flight with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/flight/1",
      dataType: "json",
      type : "PUT",
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