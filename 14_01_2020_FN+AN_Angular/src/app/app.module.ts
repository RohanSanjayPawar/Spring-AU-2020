import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatMenuModule} from '@angular/material/menu';
import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule } from  '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormDataComponent } from './components/form-data/form-data.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DisplayRecordComponent } from './components/display-record/display-record.component';

import { StoreDataService } from './provider/store-data.service';

@NgModule({
  declarations: [
    AppComponent,
    FormDataComponent,
    NotFoundComponent,
    DisplayRecordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatToolbarModule, 
    MatIconModule, 
    MatSidenavModule, 
    MatListModule, 
    MatButtonModule,
  ],
  providers: [
    StoreDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
