import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { StoreDataService } from 'src/app/provider/store-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-data',
  templateUrl: './form-data.component.html',
  styleUrls: ['./form-data.component.scss']
})
export class FormDataComponent implements OnInit {

  playerForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    nationality: new FormControl('', Validators.required),
    club: new FormControl('', Validators.required)
  });

  constructor(public storeData: StoreDataService, public router: Router) { }

  ngOnInit() {
  }

  addDetails() {
    console.log(this.playerForm.value);
    this.storeData.addNominee(this.playerForm.value);

    console.log(this.storeData.getNominee());
    this.router.navigate(['/display-data']);
  }
}
