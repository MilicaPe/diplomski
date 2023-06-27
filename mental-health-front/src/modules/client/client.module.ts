import {RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ClientRoutes} from "./client.routes";
import {MatStepperModule} from "@angular/material/stepper";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from "@angular/material/button";
import { EmotionSurveyComponent } from './pages/emotion-survey/emotion-survey.component';
import {ToastModule} from "primeng/toast";
import { QuestionStepComponent } from './components/question-step/question-step.component';
import {MatRadioModule} from "@angular/material/radio";
import { EmotionResultComponent } from './components/emotion-result/emotion-result.component';
import { MatDialogModule} from "@angular/material/dialog";
import {SharedModule} from "../shared/shared.module";
import { EmotionHistoryComponent } from './pages/emotion-history/emotion-history.component';
import {TableModule} from "primeng/table";
import { EmotionSurveyOverviewComponent } from '../shared/components/emotion-survey-overview/emotion-survey-overview.component';
import { QuestionsComponent } from './pages/questions/questions.component';
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatDividerModule} from "@angular/material/divider";
import {MatGridListModule} from "@angular/material/grid-list";
import { DiagnosticResultComponent } from './components/diagnostic-result/diagnostic-result.component';
import { AddPsychologistComponent } from './pages/add-psychologist/add-psychologist.component';
import {MatCardModule} from "@angular/material/card";
import { ViewPsychologistComponent } from './pages/view-psychologist/view-psychologist.component';
import { DiagnosticSurveyOverviewComponent } from '../shared/components/diagnostic-survey-overview/diagnostic-survey-overview.component';
import { SymptomsComponent } from './pages/symptoms/symptoms.component';
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    EmotionSurveyComponent,
    QuestionStepComponent,
    EmotionResultComponent,
    EmotionHistoryComponent,
    EmotionSurveyOverviewComponent,
    QuestionsComponent,
    DiagnosticResultComponent,
    AddPsychologistComponent,
    ViewPsychologistComponent,
    DiagnosticSurveyOverviewComponent,
    SymptomsComponent
  ],
    imports: [
        CommonModule,
        RouterModule.forChild(ClientRoutes),
        MatStepperModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatButtonModule,
        ToastModule,
        MatDialogModule,
        SharedModule,
        TableModule,
        MatPaginatorModule,
        MatRadioModule,
        MatDividerModule,
        FormsModule,
        MatGridListModule,
        MatCardModule,
        MatSelectModule,
    ],

  providers: [

  ]
})
export class ClientModule{ }
