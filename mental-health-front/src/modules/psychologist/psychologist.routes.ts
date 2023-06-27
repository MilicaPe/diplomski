import {Routes} from "@angular/router";
import {PsychologistHomeComponent} from "./pages/psychologist-home/psychologist-home.component";
import {RoleGuard} from "../auth/guards/role/role.guard";

export const PsychologistRoutes: Routes = [
  {
    path: 'home',
    pathMatch: 'full',
    component: PsychologistHomeComponent,
    canActivate: [RoleGuard],
    data: {expectedRoles: 'PSIHOLOG'}
  }

  ]
