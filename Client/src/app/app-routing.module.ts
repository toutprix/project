import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AddcaseComponent } from './addcase/addcase.component';
import { TodayComponent } from './today/today.component';
import { After } from './afterday/after.component';
import { After2 } from './afterday2/after2.component';
import { After3 } from './afterday3/after3.component';
import { All } from './all/all.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'addcase',
        component: AddcaseComponent
    },
    {
        path: 'today',
        component: TodayComponent
    },
    {
        path: 'after',
        component: After
    },
    {
        path: 'after2',
        component: After2
    },
    {
        path: 'after3',
        component: After3
    },
    {
        path: 'all',
        component: All
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
