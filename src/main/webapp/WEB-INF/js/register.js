
function rgba(r, g, b, a=1){
    return `rgba(${r}, ${g}, ${b}, ${a})`
}
function giveStyleToEmptyField(field) {
    field.style.textAlign = "center";
    field.style.borderColor ="red";
    field.style.border ="1px solid red";
    field.placeholder = "field must be filled"
}

function validate(e){
  let valid = true
  const firstName =  document.getElementById("firstName")
    const lastName =  document.getElementById("lastName")
    const email =  document.getElementById("email")
    const password = document.getElementById("password")
    const repeatPassword = document.getElementById("repeatPassword")
    const day =  document.getElementById("day")
    const mouth =  document.getElementById("mouth")
    const year =  document.getElementById("year")

    while (true) {
        if(firstName.value === '') {
            giveStyleToEmptyField(firstName)
            valid = false
           break
        }

        if (lastName.value === '') {
            giveStyleToEmptyField(lastName)
            valid = false
            break
        }
        if (email.value === '') {
            giveStyleToEmptyField(email)
            valid = false
            break
        }
        if (password.value === '') {
            giveStyleToEmptyField(password)
            valid = false
            break
        }
        if(repeatPassword.value === '') {
            giveStyleToEmptyField(repeatPassword)
            valid = false
            break
        }
        if (day.value === '') {
            giveStyleToEmptyField(day)
            valid = false
            break
        }
        if (mouth.value === '') {
            giveStyleToEmptyField(mouth)
            valid = false
            break
        }
        if (year.value === '') {
            giveStyleToEmptyField(year)
            valid = false
            break
        }
    }
valid=true;
    if(!valid) {
        e.preventDefault();
    }
}
