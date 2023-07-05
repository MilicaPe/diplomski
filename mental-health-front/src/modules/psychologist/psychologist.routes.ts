import {Routes} from "@angular/router";
import {PsychologistHomeComponent} from "./pages/psychologist-home/psychologist-home.component";
import {RoleGuard} from "../auth/guards/role/role.guard";
import {DefineRulesComponent} from "./pages/define-rules/define-rules.component";
import {AddTemplateComponent} from "./pages/add-template/add-template.component";

export const PsychologistRoutes: Routes = [
  {
    path: 'home',
    pathMatch: 'full',
    component: PsychologistHomeComponent,
    canActivate: [RoleGuard],
    data: {expectedRoles: 'PSIHOLOG'}
  },
  {
    path:'define',
    pathMatch: 'full',
    component: DefineRulesComponent,
    canActivate: [RoleGuard],
    data: {expectedRoles: 'PSIHOLOG'}
  },
  {
    path:'template',
    pathMatch: 'full',
    component: AddTemplateComponent,
    canActivate: [RoleGuard],
    data: {expectedRoles: 'PSIHOLOG'}
  }
  ]
