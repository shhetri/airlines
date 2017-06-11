**List Flight**
----
  Returns json data for list of flight.

* **URL**

  /rs/flight

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
        },
        {
            "airline": {
                "id": 10,
                "name": "oneworld"
            },
            "airplane": {
                "capacity": 519,
                "id": 11,
                "model": "A380",
                "serialnr": "23451"
            },
            "arrivalDate": "6/25/15",
            "arrivalTime": "6:15 AM",
            "departureDate": "8/5/09",
            "departureTime": "10:30 PM",
            "destination": {
                "airportcode": "SYD",
                "city": "Sydney",
                "country": "Australia",
                "id": 12,
                "name": "Kingsford Smith"
            },
            "flightnr": "QF 12",
            "id": 9,
            "origin": {
                "airportcode": "LAX",
                "city": "Los Angeles",
                "country": "USA",
                "id": 13,
                "name": "Los Angeles International"
            }
        }
    ]
    ```
 
* **Error Response:**

  None

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/flight",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```