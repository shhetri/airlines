**Find Airplane By ID**
----
  Returns json data about an airplane

* **URL**

  /rs/airplane/:id

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
           "capacity": 416,
           "id": 7,
           "model": "747",
           "serialnr": "54321"
       }
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND
  
    **Content:** `{ error : "Airplane with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airplane/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```