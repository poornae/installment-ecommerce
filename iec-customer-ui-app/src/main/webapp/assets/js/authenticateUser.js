/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function authenticateUser(event) {
  event.preventDefault(); // prevent the form from submitting
  const form = document.getElementById("form");

  // validate the first name field
  const firstNameInput = form.elements["firstName"];
  if (!firstNameInput.value.trim()) {
    alert("Please enter your first name");
    firstNameInput.focus();
    return false;
  }

  // validate the last name field
  const lastNameInput = form.elements["lastName"];
  if (!lastNameInput.value.trim()) {
    alert("Please enter your last name");
    lastNameInput.focus();
    return false;
  }

  // validate the username field
  const userNameInput = form.elements["userName"];
  if (!userNameInput.value.trim()) {
    alert("Please enter a username");
    userNameInput.focus();
    return false;
  }

  // validate the address field
  const addressInput = form.elements["address"];
  if (!addressInput.value.trim()) {
    alert("Please enter your address");
    addressInput.focus();
    return false;
  }

  // validate the email field
  const emailInput = form.elements["email"];
  const emailRegex = /^\S+@\S+\.\S+$/; // regex to validate email format
  if (!emailInput.value.trim()) {
    alert("Please enter your email address");
    emailInput.focus();
    return false;
  } else if (!emailRegex.test(emailInput.value.trim())) {
    alert("Please enter a valid email address");
    emailInput.focus();
    return false;
  }

  // validate the date of birth field
  const dobInput = form.elements["dob"];
  if (!dobInput.value.trim()) {
    alert("Please enter your date of birth");
    dobInput.focus();
    return false;
  }

  // validate the contact number field
  const contactNoInput = form.elements["contact_no"];
  if (!contactNoInput.value.trim()) {
    alert("Please enter your contact number");
    contactNoInput.focus();
    return false;
  }

  // validate the NIC field
  const nicInput = form.elements["nic"];
  if (!nicInput.value.trim()) {
    alert("Please enter your NIC number");
    nicInput.focus();
    return false;
  }

  // validate the password field
  const passwordInput = form.elements["password"];
  if (!passwordInput.value.trim()) {
    alert("Please enter a password");
    passwordInput.focus();
    return false;
  }

  // validate the confirm password field
  const confirmPasswordInput = form.elements["confirmpassword"];
  if (!confirmPasswordInput.value.trim()) {
    alert("Please confirm your password");
    confirmPasswordInput.focus();
    return false;
  } else if (passwordInput.value.trim() !== confirmPasswordInput.value.trim()) {
    alert("Passwords do not match");
    confirmPasswordInput.focus();
    return false;
  }

  // submit the form if all fields are valid
  form.submit();
}


