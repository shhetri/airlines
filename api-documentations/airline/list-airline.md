**List Airline**
----
  Returns json data for list of airlines.

* **URL**

  /rs/airline

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
            "id": 2,
            "name": "SkyTeam"
        }
    ]
    ```
 
* **Error Response:**

  None

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airline",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```