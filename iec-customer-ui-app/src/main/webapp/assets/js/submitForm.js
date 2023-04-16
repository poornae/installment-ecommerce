/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const form = document.getElementById('form');
const submitBtn = document.getElementById('btn-submit');

form.addEventListener('submit', (event) => {
    event.preventDefault(); // prevent the default form submission

    // Check if all fields are valid
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const userName = document.getElementById('userName').value;
    const address = document.getElementById('address').value;
    const email = document.getElementById('email').value;
    const dob = document.getElementById('dob').value;
    const contactNo = document.getElementById('contact_no').value;
    const nic = document.getElementById('nic').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmpassword').value;

    if (firstName && lastName && userName && address && email && dob && contactNo && nic && password && confirmPassword) {
        // All fields are valid, show alert
        swal({
            title: "You have been registered successfully!",
            type: "success",
            onClose: function () {
                form.submit();
            }
        });
        setTimeout(() => {
            document.location.reload();
        }, 3000);
    } else {
        // At least one field is invalid, show error message
        swal({
            title: "Please fill in all required fields!",
            type: "error"
        });
    }
});
