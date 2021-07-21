import { Component, OnInit } from '@angular/core';
import {ProductService} from "../model/product.service";
import {Product} from "../model/product";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  public products: Product[] = [];

  constructor(public productService: ProductService) { }

  ngOnInit(): void {
    this.productService.findAll().then( res => {
        this.products = res;
      }
    ).catch(err => {
      console.log(err);
    })
  }


}
