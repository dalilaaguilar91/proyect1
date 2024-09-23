import React, { useState, useEffect } from 'react';
import { getProducts } from '../services/productService';

const ProductList = () => {
  const [productos, setProductos] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await getProducts();
      setProductos(result);
    };
    fetchData();
  }, []);

  return (
    <div className="product-list">
      {productos.map((producto) => (
        <div key={producto.id} className="product-card">
          <img src={producto.imagen} alt={producto.nombre} />
          <h3>{producto.nombre}</h3>
          <p>{producto.descripcion}</p>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
