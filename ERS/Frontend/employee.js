const url = "http://localhost:3000/"

var formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  
    // These options are needed to round to whole numbers if that's what you want.
    //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
    //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
  });

document.getElementById("showPreviousButton").addEventListener("click", getByAuthor);
document.getElementById("newRequestButton").addEventListener("click", gotoRequest);

function gotoRequest(){
    window.location.href = "request.html";
}

async function getByAuthor() {
    let body = document.getElementById("reimbursementBody")
    body.remove()
    let newbody = document.createElement("tbody")
    newbody.id = "reimbursementBody"
    document.getElementById("reimbTable").appendChild(newbody)

    let id = document.getElementById("employeeID").value
    //we will send a fetch request to get our employee data
    //by default, fetch requests send GET requests
    let response = await fetch(url + "reimbursements/" + id, {credentials: "include"});

    //logging the response in the console just to see the response object
    console.log(response);

    //control flow for is the request is successful
    if(response.status === 200){
        let i = 0;

        

        let data = await response.json(); //parse the JSON data from the response into a JS object

        //logging the actual employee data that has been parsed from JSON -> JS
        console.log(data);


        //For every Employee object we got back (stored in the data variable), put it in the table
        for(let reimbursement of data){
            
            //create a table row
            let row = document.createElement("tr");

            //create a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with the appropriate employee data
            cell.innerHTML = reimbursement.id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we'll do this^ for every column in employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.author;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = formatter.format(reimbursement.amount);
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            if (reimbursement.reimb_type == 1){
            cell4.innerHTML = "TRAVEL";
            }
            else if ( reimbursement.reimb_type == 2){
                cell4.innerHTML = "LODGING";
            }
            else if ( reimbursement.reimb_type == 3){
                cell4.innerHTML = "FOOD";
            }
            else if ( reimbursement.reimb_type == 4){
                cell4.innerHTML = "OTHER";
            }
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            if( reimbursement.status == 1){
                cell5.innerHTML = "PENDING";
            }
            else if( reimbursement.status == 2){
                cell5.innerHTML = "APPROVED";
            }
            else if( reimbursement.status == 3){
                cell5.innerHTML = "DENIED";
            }
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.resolver;
            row.appendChild(cell6);

            
        


            //append the tr called row that we created in the for loop to the table body
            //a new row will be appended for every employee object that comes in
            newbody.appendChild(row);
            
        }

    }
}
