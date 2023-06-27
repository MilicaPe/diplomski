import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './pages/login/login.component';
import {RouterModule} from "@angular/router";
import {AuthRoutes} from "./auth.routes";
import {ReactiveFormsModule} from "@angular/forms";
import {ToastModule} from "primeng/toast";
import { RegistrationComponent } from './pages/registration/registration.component';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    RouterModule.forChild(AuthRoutes),
    CommonModule,
    ReactiveFormsModule,
    ToastModule,
    MatCardModule,
    MatFormFieldModule,
    MatGridListModule,
    MatInputModule,
    MatButtonModule
  ]
})
export class AuthModule { }
