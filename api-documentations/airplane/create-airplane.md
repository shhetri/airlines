**Create Airplane**
----
  Create an airplane

* **URL**

  /rs/airplane/create

* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**

  **Required:** `capacity=[integer]`
  
  **Required:** `model=[string]`
  
  **Required:** `serialnr=[string]`

* **Success Response:**

  * **Code:** 200
  
    **Content:** 
    ```
    {
        "capacity": 416,
        "id": 7,
        "model": "747",
        "serialnr": "54321"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
  
    **Content:** `{ error : "Cannot create airplane" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airplane/create",
      dataType: "json",
      type : "POST",
      data: {"capacity": 500, "model": "747", "serialnr": "Kathmandu"},
      success : function(r) {
        console.log(r);
      }
    });
  ```