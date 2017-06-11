**Delete Airline**
----
  Delete an airline

* **URL**

  /rs/airline/:id

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
        "success": "Successfully deleted airline with id: id"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
    **Content:** `{ error : "Unable to delete airline with id: id" }`
  
    OR
  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Airline with id :id doesn't exist." }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/rs/airline/1",
      dataType: "json",
      type : "DELETE",
      success : function(r) {
        console.log(r);
      }
    });
  ```