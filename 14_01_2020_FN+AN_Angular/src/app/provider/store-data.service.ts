import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StoreDataService {

  nominees = [
    {
      'firstName': 'Lionel',
      'lastName': 'Messi',
      'nationality': 'Argentina',
      'club': 'FCB'
    },{
      'firstName': 'Cristiano',
      'lastName': 'Ronaldo',
      'nationality': 'Portugal',
      'club': 'JUV'
    },{
      'firstName': 'Killian',
      'lastName': 'Mbappe',
      'nationality': 'France',
      'club': 'PSG'
    },{
      'firstName': 'Sadio',
      'lastName': 'Mane',
      'nationality': 'Senegal',
      'club': 'LIV'
    },{
      'firstName': 'Frankie',
      'lastName': 'DeJong',
      'nationality': 'Netherland',
      'club': 'FCB'
    }
  ]

  constructor() { }

  getNominee() {
    return this.nominees;
  }

  addNominee(nominee) {
    this.nominees.push(nominee);
  }

  deleteIndex(index) {
    this.nominees.splice(index, 1);
  }
}
