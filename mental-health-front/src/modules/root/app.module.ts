import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RootComponent } from './pages/root/root.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {ClientModule} from "../client/client.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {AuthModule} from "../auth/auth.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { ClientHeaderComponent } from './components/client-header/client-header.component';
import {TooltipModule} from "primeng/tooltip";
import {AuthInterceptor} from "../shared/interceptors/auth.interceptor";
import {PsychologistModule} from "../psychologist/psychologist.module";
import { PsychologistHeaderComponent } from './components/psychologist-header/psychologist-header.component';

@NgModule({
  declarations: [
    AppComponent,
    RootComponent,
    NotFoundComponent,
    ClientHeaderComponent,
    PsychologistHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClientModule,
    PsychologistModule,
    BrowserAnimationsModule,
    MatButtonModule,
    AuthModule,
    HttpClientModule,
    TooltipModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
