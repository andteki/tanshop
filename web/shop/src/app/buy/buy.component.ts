import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
  products !: any;
  
  constructor(
    private api:ApiService
  ) { }

  ngOnInit(): void {
    this.getProducts();
  }
  getProducts() {
    this.api.getProducts().subscribe({
      next: (res) => {
        console.log(res);
        this.products = res;
      },
      error: () => {}
    })
  }
  tocart(product:any) {
    console.log("Kosárba")
    console.log(product.name)
  }
}
