**Find Flight By ID**
----
  Returns json data about an flight

* **URL**

  /rs/flight/:id

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

  * **Code:** 404 NOT FOUND
  
    **Content:** `{ error : "Flight with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/flight/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```