<?php

use App\Http\Controllers\OrderController;
use App\Http\Controllers\OrderitemController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use \App\Http\Controllers\ProductController;
use \App\Http\Controllers\AuthController;
use \App\Http\Controllers\UserController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group([ "middleware" => [ "auth:sanctum" ]], function() {

    Route::post( "/logout", [ AuthController::class, "logout" ]);

    Route::post( "/products", [ ProductController::class, "create" ]);
    Route::put( "/products/{id}", [ ProductController::class, "update" ]);
    Route::delete( "/products/{id}", [ ProductController::class, "destroy" ]);
});

Route::post( "/register", [ AuthController::class, "signUp" ]);
Route::post( "/login", [ AuthController::class, "signIn" ]);
Route::get( "/products", [ ProductController::class, "index" ]);
Route::get( "/product/{id}", [ ProductController::class, "show" ]);

Route::get( "/users", [ UserController::class, "index" ]);

Route::get( "/orderitems", [ OrderitemController::class, "index" ]);
Route::post( "/orderitems", [ OrderitemController::class, "store" ]);
Route::put( "/orderitems", [ OrderitemController::class, "update" ]);
Route::delete( "/orderitems", [ OrderitemController::class, "destroy" ]);

Route::get( "/orders", [ OrderController::class, "index" ]);
Route::post( "/orders", [ OrderController::class, "store" ]);
Route::put( "/orders", [ OrderController::class, "update" ]);
Route::delete( "/orders", [ OrderController::class, "destroy" ]);


Route::get( "/orders2", [ OrderController::class, "getOrders" ]);


