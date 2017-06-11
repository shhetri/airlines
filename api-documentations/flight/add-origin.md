**Add origin to flight**
----
  Add origin airport to a flight

* **URL**

  /rs/flight/:flightId/airport/:originId

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:** `flightId=[integer]`
   
   **Required:** `originId=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200
  
    **Content:** 
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
          "origin": {
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

  * **Code:** 404 NOT FOUND
  
    **Content:** `{ error : "Flight or origin airport not found." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/flight/1/airport/2",
      dataType: "json",
      type : "PUT",
      success : function(r) {
        console.log(r);
      }
    });
  ```