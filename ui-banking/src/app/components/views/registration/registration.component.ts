import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MustMatch } from 'src/app/helper/must-match.validator';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {

  registerForm: FormGroup;
  submitted = false;

  constructor(
    private userService: UserService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      // firstName: ['', Validators.required],
      // middleName: ['', Validators.required],
      // lastName: ['', Validators.required],
      emailID: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(5)]],
    }, {
      validator: MustMatch('password', 'confirmPassword')
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  signup() {
    this.submitted = true;
    console.log(this.f);

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      console.log("Form validataionfailed")
      return;
    }

    console.log(JSON.stringify(this.registerForm.value));

    this.userService.saveUser(JSON.stringify(this.registerForm.value)).subscribe(
      response => {
        console.log(response);
      }
    );
    

  }


  error_messages = {
    'firstName': [
      { type: 'required', message: 'First Name is required.' },
    ],

    'lastName': [
      { type: 'required', message: 'Last Name is required.' }
    ],

    'emailID': [
      { type: 'required', message: 'Email is required.' },
      { type: 'minlength', message: 'Email length.' },
      { type: 'maxlength', message: 'Email length.' },
      { type: 'email', message: 'Please enter a valid email address.' }
    ],

    'password': [
      { type: 'required', message: 'password is required.' },
      { type: 'minlength', message: 'password length.' },
      { type: 'maxlength', message: 'password length.' }
    ],
    'confirmPassword': [
      { type: 'required', message: 'password is required.' },
      { type: 'minlength', message: 'password length.' },
      { type: 'maxlength', message: 'password length.' },
      { type: 'mustMatch', message: 'Confirm password is not matching.' }
    ],
  }
}
