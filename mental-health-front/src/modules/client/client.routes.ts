import {Routes} from "@angular/router";
import {RoleGuard} from "../auth/guards/role/role.guard";
import {EmotionSurveyComponent} from "./pages/emotion-survey/emotion-survey.component";
import {EmotionHistoryComponent} from "./pages/emotion-history/emotion-history.component";
import {DiagnosticSurveyComponent} from "./pages/diagnostic-survey/diagnostic-survey.component";
import {AddPsychologistComponent} from "./pages/add-psychologist/add-psychologist.component";
import {ViewPsychologistComponent} from "./pages/view-psychologist/view-psychologist.component";
import {SymptomsComponent} from "./pages/symptoms/symptoms.component";


export const ClientRoutes: Routes = [
  {
    path: 'questionnaire',
    pathMatch: 'full',
    component: DiagnosticSurveyComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: 'KLIJENT' }
  },
  {
    path: 'emotion',
    pathMatch: 'full',
    component: EmotionSurveyComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: 'KLIJENT' }
  },
  {
    path: 'emotion/history',
    pathMatch: 'full',
    component: EmotionHistoryComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: 'KLIJENT' }
  },
  {
    path: 'psychologist',
    pathMatch: 'full',
    component: AddPsychologistComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: 'KLIJENT' }
  },
  {
    path: 'list',
    pathMatch: 'full',
    component: ViewPsychologistComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: 'KLIJENT' }
  },
  {
    path:'symptom',
    pathMatch: 'full',
    component: SymptomsComponent,
    canActivate: [RoleGuard],
    data:{expectedRoles: 'KLIJENT'}
  }
  ]
