**List Airplane**
----
  Returns json data for list of airplane.

* **URL**

  /rs/airplane

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
            "capacity": 416,
            "id": 7,
            "model": "747",
            "serialnr": "54321"
        },
        {
            "capacity": 519,
            "id": 11,
            "model": "A380",
            "serialnr": "23451"
        }
    ]
    ```
 
* **Error Response:**

  None

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airplane",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```