import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormDataComponent } from './components/form-data/form-data.component';
import { DisplayRecordComponent } from './components/display-record/display-record.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  {path: 'fill-data', component: FormDataComponent},
  {path: 'display-data', component: DisplayRecordComponent},
  {path: '', component: FormDataComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
