import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PsychologistHomeComponent } from './pages/psychologist-home/psychologist-home.component';
import {RouterModule} from "@angular/router";
import {PsychologistRoutes} from "./psychologist.routes";
import {MatTabsModule} from "@angular/material/tabs";
import { UserReportComponent } from './components/user-report/user-report.component';
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {SharedModule} from "../shared/shared.module";
import {TableModule} from "primeng/table";
import { ReportBasedOnJobAgeComponent } from './components/report-based-on-job-age/report-based-on-job-age.component';
import {MatInputModule} from "@angular/material/input";
import {MatDividerModule} from "@angular/material/divider";
import { ReportDetectionTimeComponent } from './components/report-detection-time/report-detection-time.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatFormFieldModule} from "@angular/material/form-field";
import {ChartModule} from "primeng/chart";
import {ToastModule} from "primeng/toast";
import { DefineRulesComponent } from './pages/define-rules/define-rules.component';
import { RuleParamsComponent } from './components/rule-params/rule-params.component';
import { AddTemplateComponent } from './pages/add-template/add-template.component';




@NgModule({
  declarations: [
    PsychologistHomeComponent,
    UserReportComponent,
    ReportBasedOnJobAgeComponent,
    ReportDetectionTimeComponent,
    DefineRulesComponent,
    RuleParamsComponent,
    AddTemplateComponent
  ],
    imports: [
        CommonModule,
        RouterModule.forChild(PsychologistRoutes),
        MatTabsModule,
        MatSelectModule,
        FormsModule,
        MatButtonModule,
        SharedModule,
        TableModule,
        MatInputModule,
        MatDividerModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatDatepickerModule,
        MatNativeDateModule,
        ChartModule,
        ToastModule
    ]
})
export class PsychologistModule { }
