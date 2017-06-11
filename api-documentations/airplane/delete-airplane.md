**Delete Airplane**
----
  Delete an airplane

* **URL**

  /rs/airplane/:id

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
        "success": "Successfully deleted airplane with id: id"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Unable to delete airplane with id: id" }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Airplane with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airplane/1",
      dataType: "json",
      type : "DELETE",
      success : function(r) {
        console.log(r);
      }
    });
  ```