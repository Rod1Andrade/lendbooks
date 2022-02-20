import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class AuthInteceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const accessToken = localStorage.getItem('accessToken');
    const refreshToken = localStorage.getItem('refreshToken');
    if(accessToken) {
      req.headers.set('Authorization', `Bearer ${accessToken}`);
      req.headers.set('refreshToken', `Bearer ${refreshToken}`);

      const cloned = req.clone({
        headers: req.headers
      });

      return next.handle(cloned);
    }

    return next.handle(req);

  }
}
