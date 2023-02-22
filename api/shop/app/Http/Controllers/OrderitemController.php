<?php

namespace App\Http\Controllers;

use App\Models\Orderitem;
use Illuminate\Http\Request;

class OrderitemController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return Orderitem::all();
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        return Orderitem::create($request->all());
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Orderitem  $orderitem
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        return Orderitem::find($id);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Orderitem  $orderitem
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $orderitem = Orderitem::find($id);
        $orderitem->update($request->all());
        return $orderitem;
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Orderitem  $orderitem
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        return Orderitem::destroy($id);
    }
}
