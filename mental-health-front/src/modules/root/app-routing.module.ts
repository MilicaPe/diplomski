import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RootComponent} from "./pages/root/root.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";

const routes: Routes = [
  {
    path: 'auth',
    children:[
      {
        path:'',
        component: RootComponent,
        loadChildren:() => import('../auth/auth.module').then((m)=>m.AuthModule)
      }
    ]
  },
  {
    path: 'client',
    children:[
      {
        path:'',
        component:RootComponent,
        loadChildren:() => import('../client/client.module').then((m)=>m.ClientModule)
      }
    ]
  },
  {
    path: 'psychologist',
    children:[
      {
        path:'',
        component:RootComponent,
        loadChildren:() => import('../psychologist/psychologist.module').then((m)=>m.PsychologistModule)
      }
    ]
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
