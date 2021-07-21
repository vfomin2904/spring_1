import {Injectable, NgModule} from '@angular/core';
import {Product} from "./product";
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private identity: number = 6;

  private products:{ [key: number]: Product} = {
    1: new Product(1, "Apple", 18),
    2: new Product(2, "Banana", 16),
    3: new Product(3, "Orange", 9),
  }

  constructor(public http: HttpClient) { }

  public findAll(){
    return this.http.get<Product[]>('/api/v1/product/all').toPromise();
  }

  public findById(id: number) {
    return this.http.get<Product>(`/api/v1/product/${id}`).toPromise();
  }

  public save(product: Product) {
    if (product.id == null) {
      return this.http.post('/api/v1/product', product).toPromise()
    } else {
      return this.http.put('/api/v1/product', product).toPromise()
    }
  }

  public delete(id: number) {
    return this.http.delete<Product>(`/api/v1/product/${id}`).toPromise();
  }
}

