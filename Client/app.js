$(document).ready(function(){
 


    axios
    .get('http://localhost:8080/employee/all')
    .then(response =>{
     
        var template = 
        `<table class="table">
            <thead>
            <tr>
                <th scope="col">Last Name</th>
                <th scope="col">First Name</th>
                <th scope="col">Address</th>
                <th scope="col">City</th>
            </tr>
            </thead>
            <tbody>`+
            response.data.map(employee =>{
                return `
                    <tr>
                        <th scope="row">${employee.lastName}</th>
                        <td>${employee.firstName}</td>
                        <td>${employee.address}</td>
                        <td>${employee.city}</td>
                        <td>
                        <button type="button" 
                        class="btn btn-primary" 
                        data-toggle="modal" 
                        data-target="#exampleModal" 
                        data-whatever="Joe"
                        data-employeeId="${employee.employeeId}"
                        data-lastName="${employee.lastName}"
                        data-firstName="${employee.firstName}"
                        data-address="${employee.address}"
                        data-city="${employee.city}"
                        onclick="openModal(this)"
                        >
                        Update
                        </button>
                        </td>
                    </tr>
                `
            }).join("");
         
            +
            `
            </tbody>
        </table>`
       
        document.getElementById("employee-table").innerHTML=template
        
    })


});

function openModal(event){
    let employeeId =event.getAttribute("data-employeeId");
    $(".modal-body #recipient-name").val( employeeId );

}




    