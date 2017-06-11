**Delete Flight**
----
  Delete an flight

* **URL**

  /rs/flight/:id

* **Method:**

  `DELETE`
  
*  **URL Params**

   **Required:** `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200
  * **Content:** 
    ```
    {
        "success": "Successfully deleted flight with id: id"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Unable to delete flight with id: id" }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Flight with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/flight/1",
      dataType: "json",
      type : "DELETE",
      success : function(r) {
        console.log(r);
      }
    });
  ```