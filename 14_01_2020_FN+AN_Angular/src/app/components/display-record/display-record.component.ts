import { Component, OnInit } from '@angular/core';
import { StoreDataService } from 'src/app/provider/store-data.service';

@Component({
  selector: 'app-display-record',
  templateUrl: './display-record.component.html',
  styleUrls: ['./display-record.component.scss']
})
export class DisplayRecordComponent implements OnInit {

  nominees = [];

  constructor(public storeData: StoreDataService) {

  }

  ngOnInit() {
    this.nominees = this.storeData.getNominee()
  }

  delete(index) {
    console.log(index);
    this.storeData.deleteIndex(index);
    this.nominees = this.storeData.getNominee()
  }

}
