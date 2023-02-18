import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './adm/admin/admin.component';
import { BuyComponent } from './buy/buy.component';
import { LoginComponent } from './adm/login/login.component';
import { ProductsComponent } from './adm/products/products.component';
import { AuthGuard } from './shared/auth.guard';
import { WebsiteComponent } from './website/website.component';

const routes: Routes = [
  {
    path: 'admin', component: AdminComponent,
    children: [
      {path: 'login', component: LoginComponent},
      {path: 'products', component: ProductsComponent,  canActivate: [AuthGuard]}      
    ]
  },
  {
    path: '', component: WebsiteComponent,
    children: [
      { path: 'buy', component: BuyComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
