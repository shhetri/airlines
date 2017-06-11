**Update Airplane**
----
  Update an airplane

* **URL**

  /rs/airplane/:id

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:** `id=[integer]`

* **Data Params**

  **Required:** `capacity=[integer]`
    
  **Required:** `model=[string]`
    
  **Required:** `serialnr=[string]`

* **Success Response:**

  * **Code:** 200
  * **Content:** 
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
    **Content:** `{ error : "Update failed." }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Airplane with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airplane/1",
      dataType: "json",
      type : "PUT",
      data: {"capacity": 416, "model": "417", "serialnr": "54321"},
      success : function(r) {
        console.log(r);
      }
    });
  ```