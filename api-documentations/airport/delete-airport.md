**Delete Airport**
----
  Delete an airport

* **URL**

  /rs/airport/:id

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
        "success": "Successfully deleted airport with id: id"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Unable to delete airport with id: id" }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Airport with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airport/1",
      dataType: "json",
      type : "DELETE",
      success : function(r) {
        console.log(r);
      }
    });
  ```